#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.agapsys.agreste.test.ColoredConsoleLogStream;
import com.agapsys.web.toolkit.modules.LogModule;

public class TestApplication extends Application {

	@Override
	public boolean isAbuseCheckEnabled() {
		return false; // <-- Required for tests
	}

	@Override
	protected void beforeApplicationStart() {
		super.beforeApplicationStart();

		LogModule logModule = getModule(LogModule.class);
		logModule.addStream(new ColoredConsoleLogStream());
	}

}
