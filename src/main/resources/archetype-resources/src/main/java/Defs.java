#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

public class Defs {
    // CLASS SCOPE =============================================================
    public static final String APP_NAME   = "${artifactId}";
    public static final String APP_VERSION = "${version}";
    // =========================================================================

    // INSTANCE SCOPE ==========================================================
    private Defs() {}
    // =========================================================================
}
