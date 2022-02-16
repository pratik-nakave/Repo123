/**
 * 
 */
package edu.neu.csye6225;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pratiknakave
 *
 */
@RestController
@RequestMapping("/api")
public class Health {

	@GetMapping("/healthz")
	public ResponseEntity<String> getStatus() {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("access-control-allow-credentials", "true");
		responseHeaders.set("access-control-allow-headers", "X-Requested-With,Content-Type,Accept,Origin");
		responseHeaders.set("access-control-allow-origin", "*");
		responseHeaders.set("access-control-allow-methods", "*");
		responseHeaders.set("cache-control", "no-cache");
		responseHeaders.set("content-encoding", "gzip");
		responseHeaders.set("content-type", "application/json; charset=utf-8");

		return new ResponseEntity<String>(null, responseHeaders, HttpStatus.OK);
	}
}
