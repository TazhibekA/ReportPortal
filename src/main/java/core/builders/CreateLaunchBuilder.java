package core.builders;

import com.google.gson.JsonObject;

public class CreateLaunchBuilder {
	public String name;
	public String description;
	public String startTime;
	public String mode;

	public CreateLaunchBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public CreateLaunchBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CreateLaunchBuilder withStartTime(String startTime){
		this.startTime = startTime;
		return this;
	}

	public CreateLaunchBuilder withMode(String mode){
		this.mode = mode;
		return this;
	}

	public String build() {
		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("description", description);
		requestBody.addProperty("name", name);
		requestBody.addProperty("startTime", startTime);
		requestBody.addProperty("mode", mode);

		return requestBody.toString();
	}
}
