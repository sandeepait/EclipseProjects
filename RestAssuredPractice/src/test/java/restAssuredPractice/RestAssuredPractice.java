package restAssuredPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class RestAssuredPractice {

	public static String id;

	@Test
	public void doPracticeRestAssured() {

		RestAssured.baseURI = "https://api.twitter.com";

		Response res = given().param("id", "1035519459350343681").header("Authorization",
				"OAuth oauth_consumer_key=\"0IUqhuFf4LkVLVLb0XVUZPJuv\",oauth_token=\"1035526526144598016-Kqua2zNFkwXTpjv6KL4Xxt40q97vPI\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1535735511\",oauth_nonce=\"WUwxUi08ncH\",oauth_version=\"1.0\",oauth_signature=\"effdTaouXS7Enii8FuEYqAk9ff8%3D\"")
				.when().get("/1.1/statuses/show.json").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("user.id_str", equalTo("18839785")).and()
				.body("text", containsString("I thank my sisters and brothers of Nepal")).and()
				.header("pragma", "no-cache").extract().response();

		System.out.println(res.asString());

	}

	public void doPracticeRestAssuredPostData() {

		String ApiKey = "0IUqhuFf4LkVLVLb0XVUZPJuv";
		String ApiSecretKey = "zNEtM8w4OpYUWOd6BsvTavo7PFzn7FLZF5yipN7QTS3QsmlR0Z";
		String AccessToken = "1035526526144598016-Kqua2zNFkwXTpjv6KL4Xxt40q97vPI";
		String AccessTokenSecretKey = "UgDLA2U2joE44BxBJTgvy57OYjC6LtE5SAIIDj4udFjBW";

		RestAssured.baseURI = "https://api.twitter.com";

		Response res = given().auth().oauth(ApiKey, ApiSecretKey, AccessToken, AccessTokenSecretKey)
				.queryParam("status", "Second Tweet from Eclipse To be deleted as soon as createda").when()
				.post("1.1/statuses/update.json").then().extract().response();

		System.out.println(res.asString());
		JsonPath js = new JsonPath(res.asString());
		id = js.get("id").toString();
		System.out.println("Following is the new tweet added");
		System.out.println(js.get("text"));
		System.out.println(js.get("id"));
	}

	@Test
	public void doPracticeRestAssuredGetLastTweet() {

		String ApiKey = "0IUqhuFf4LkVLVLb0XVUZPJuv";
		String ApiSecretKey = "zNEtM8w4OpYUWOd6BsvTavo7PFzn7FLZF5yipN7QTS3QsmlR0Z";
		String AccessToken = "1035526526144598016-Kqua2zNFkwXTpjv6KL4Xxt40q97vPI";
		String AccessTokenSecretKey = "UgDLA2U2joE44BxBJTgvy57OYjC6LtE5SAIIDj4udFjBW";

		RestAssured.baseURI = "https://api.twitter.com";

		Response res = given().auth().oauth(ApiKey, ApiSecretKey, AccessToken, AccessTokenSecretKey)
				.queryParam("count", "1").when().get("1.1/statuses/home_timeline.json").then().extract().response();

		System.out.println(res.asString());
		System.out.println("Following is the latest tweet");
		JsonPath js = new JsonPath(res.asString());
		System.out.println(js.get("text"));
		System.out.println(js.get("id").toString());
	}

	@Test
	public void doPracticeRestAssuredDeleteTweet() {

		doPracticeRestAssuredPostData();

		String ApiKey = "0IUqhuFf4LkVLVLb0XVUZPJuv";
		String ApiSecretKey = "zNEtM8w4OpYUWOd6BsvTavo7PFzn7FLZF5yipN7QTS3QsmlR0Z";
		String AccessToken = "1035526526144598016-Kqua2zNFkwXTpjv6KL4Xxt40q97vPI";
		String AccessTokenSecretKey = "UgDLA2U2joE44BxBJTgvy57OYjC6LtE5SAIIDj4udFjBW";

		RestAssured.baseURI = "https://api.twitter.com";

		Response res = given().auth().oauth(ApiKey, ApiSecretKey, AccessToken, AccessTokenSecretKey).when()
				.post("1.1/statuses/destroy" + id + ".json").then().extract().response();

		System.out.println(res.asString());

		System.out.println("Tweet which got deleted");

		JsonPath js = new JsonPath(res.asString());
		System.out.println(js.get("text"));
		System.out.println(js.get("truncated"));
	}

}
