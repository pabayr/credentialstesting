package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

// Specific Decorator
public class HashDecorator extends Decorator {

    Credentials idk;

    // Needed for the  Object to be decorated
    public HashDecorator(ExportCredentials exportCredentials) {
        super(exportCredentials);
    }

// Iterates through list and changes the password with sha 256 hex, than recalls function.
    public void export(List<Credentials> credentialsList) {


        for (int i = 0; i < credentialsList.size(); i++) {
            Credentials credentials = credentialsList.get(i);
            String sha256str = Hashing.sha256()
                    .hashString(credentials.getPwd(), StandardCharsets.UTF_8)
                    .toString();
            credentials.setPwd(sha256str);

        }
        exportCredentials.export(credentialsList);

    }
}

