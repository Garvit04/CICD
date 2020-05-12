import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Prod {


private static final String POST_URL = "https://api.boomi.com/api/rest/v1/traininggarvitmaheshwari-PSQHLZ/DeployedPackage/";

private static final String POST_PARAMS = "{\n" + "\"environmentId\" : \"b296bb79-ed4c-4e45-a7d9-2c67ec38d70a\",\r\n" + "\"packageId\" : \"2b9e6d3a-fdae-483a-8581-62f62e4dc5cc\",\r\n" + "\"notes\" : \"Package deployment via Rest request\"" + "\n}";

public static void main(String[] args) throws IOException {


sendPOST();
System.out.println("POST DONE");
}

private static void sendPOST() throws IOException {
URL obj = new URL(POST_URL);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
con.setRequestProperty("Content-Type", "application/json");
con.setRequestProperty("Authorization", "Basic R2Fydml0Lm1haGVzaHdhcmlAbmVvc2FscGhhLmNvbTpHYXJ2aXQ0NEA=");

// For POST only - START
con.setDoOutput(true);
OutputStream os = con.getOutputStream();
os.write(POST_PARAMS.getBytes());
os.flush();
os.close();
// For POST only - END

int responseCode = con.getResponseCode();
System.out.println("POST Response Code :: " + responseCode);

if (responseCode == HttpURLConnection.HTTP_OK) { //success
BufferedReader in = new BufferedReader(new InputStreamReader(
con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
response.append(inputLine);
}
in.close();

// print result
System.out.println(response.toString());
} else {
System.out.println("POST request not worked");
}
}

}
