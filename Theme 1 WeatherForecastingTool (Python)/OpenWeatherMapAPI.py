import requests
import json

def get_weather_forecast(api_key, location):
    base_url = "http://api.openweathermap.org/data/2.5/weather"
    forecast_url = "http://api.openweathermap.org/data/2.5/forecast"

    # Current weather
    params = {
        "q": location,
        "appid": api_key,
        "units": "metric"
    }
    response = requests.get(base_url, params=params)
    current_weather_data = json.loads(response.text)

    # Forecast
    params["cnt"] = 5  # Number of forecast entries (up to 40)
    forecast_response = requests.get(forecast_url, params=params)
    forecast_data = json.loads(forecast_response.text)

    # Display current weather
    print(f"Current Weather in {location}:")
    print(f"Weather: {current_weather_data['weather'][0]['main']}")
    print(f"Temperature: {current_weather_data['main']['temp']}°C")
    print(f"Humidity: {current_weather_data['main']['humidity']}%")
    print()

    # Display forecast
    print("5-Day Weather Forecast:")
    for entry in forecast_data["list"]:
        date = entry["dt_txt"].split()[0]
        time = entry["dt_txt"].split()[1]
        weather = entry["weather"][0]["main"]
        temp = entry["main"]["temp"]
        print(f"{date} - {time} | Weather: {weather} | Temperature: {temp}°C")

# Replace <YOUR_API_KEY> with your actual API key
api_key = "<YOUR_API_KEY>"
location = "New York, US"  # Replace with the desired location

get_weather_forecast(api_key, location)
