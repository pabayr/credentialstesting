package at.itkolleg.credentials;

import java.util.List;

// Has a "Has a" relationship with ExportCredentials. This is an
// Aggregation Relationship
public abstract class Decorator implements ExportCredentials {
    ExportCredentials exportCredentials;

    // All decorators can dynamically customize the Credentials of ExportCredentials
    // instance  because of this

    public Decorator(ExportCredentials exportCredentials) {
        this.exportCredentials = exportCredentials;
    }

    public void export (List<Credentials> credentialsList)
    {
        exportCredentials.export(credentialsList);
    }
}
