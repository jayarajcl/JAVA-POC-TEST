<<<<<<< HEAD
package com.veracode.verademo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
=======
import java.net.InetAddress;
import java.net.UnknownHostException;
>>>>>>> 9b0c7a8 (java trust index)
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("request")
public class ToolsController {
	private static final Logger logger = LogManager.getLogger("VeraDemo:ToolsController");

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public String tools() {
		return "tools";
	}

	@RequestMapping(value = "/tools", method = RequestMethod.POST)
	public String tools(@RequestParam(value = "host", required = false) String host, @RequestParam(value = "fortunefile", required = false) String fortuneFile, Model model) {
		model.addAttribute("ping", host != null ? ping(host) : "");

		if (fortuneFile == null) {
			fortuneFile = "literature";
		}
		model.addAttribute("fortunes", fortune(fortuneFile));

		return "tools";
	}
<<<<<<< HEAD

	private String ping(String host) {
		String output = "";
		Process proc;

		logger.info("Pinging: " + host);

		try {
			/* START EXAMPLE VULNERABILITY */
			proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ping -c1 " + host });
			/* END EXAMPLE VULNERABILITY */

			proc.waitFor(5, TimeUnit.SECONDS);
			InputStreamReader isr = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null) {
				output += line + "\n";
			}

			logger.info(proc.exitValue());
		} catch (IOException ex) {
			logger.error(ex);
		} catch (InterruptedException ex) {
			logger.error(ex);
		}

		return output;
	}

=======
//78-----------------------------------78----------78---------------
	private String ping(String host) {
    String output = "";
    logger.info("Pinging: " + host);

    try {
        InetAddress address = InetAddress.getByName(host);
        boolean reachable = address.isReachable(5000); // Timeout of 5 seconds
        output = address.getHostName() + " is " + (reachable ? "reachable" : "unreachable");
    } catch (UnknownHostException e) {
        logger.error("Unknown host: " + e.getMessage());
    } catch (IOException e) {
        logger.error("Error pinging host: " + e.getMessage());
    }

    return output;
}
//78-------------------------------------------78-----------78---------
>>>>>>> 9b0c7a8 (java trust index)
	private String fortune(String fortuneFile) {
		String cmd = "/bin/fortune " + fortuneFile;

		String output = "";
		Process proc;
		try {
			/* START EXAMPLE VULNERABILITY */
			proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", cmd });
			/* END EXAMPLE VULNERABILITY */

			proc.waitFor(5, TimeUnit.SECONDS);
			InputStreamReader isr = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null) {
				output += line + "\n";
			}
		} catch (IOException ex) {
			logger.error(ex);
		} catch (InterruptedException ex) {
			logger.error(ex);
		}

		return output;
	}
}
=======
package com.veracode.verademo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("request")
public class ToolsController {
	private static final Logger logger = LogManager.getLogger("VeraDemo:ToolsController");

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public String tools() {
		return "tools";
	}

	@RequestMapping(value = "/tools", method = RequestMethod.POST)
	public String tools(@RequestParam(value = "host", required = false) String host, @RequestParam(value = "fortunefile", required = false) String fortuneFile, Model model) {
		model.addAttribute("ping", host != null ? ping(host) : "");

		if (fortuneFile == null) {
			fortuneFile = "literature";
		}
		model.addAttribute("fortunes", fortune(fortuneFile));

		return "tools";
	}

	private String ping(String host) {
		String output = "";
		Process proc;

		logger.info("Pinging: " + host);

		try {
			/* START EXAMPLE VULNERABILITY */
			proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ping -c1 " + host });
			/* END EXAMPLE VULNERABILITY */

			proc.waitFor(5, TimeUnit.SECONDS);
			InputStreamReader isr = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null) {
				output += line + "\n";
			}

			logger.info(proc.exitValue());
		} catch (IOException ex) {
			logger.error(ex);
		} catch (InterruptedException ex) {
			logger.error(ex);
		}

		return output;
	}

	private String fortune(String fortuneFile) {
		String cmd = "/bin/fortune " + fortuneFile;

		String output = "";
		Process proc;
		try {
			/* START EXAMPLE VULNERABILITY */
			proc = Runtime.getRuntime().exec(new String[] { "bash", "-c", cmd });
			/* END EXAMPLE VULNERABILITY */

			proc.waitFor(5, TimeUnit.SECONDS);
			InputStreamReader isr = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String line;

			while ((line = br.readLine()) != null) {
				output += line + "\n";
			}
		} catch (IOException ex) {
			logger.error(ex);
		} catch (InterruptedException ex) {
			logger.error(ex);
		}

		return output;
	}
}
>>>>>>> f466778 (C# Project)
