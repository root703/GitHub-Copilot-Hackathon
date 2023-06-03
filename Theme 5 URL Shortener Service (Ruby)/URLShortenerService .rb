require 'securerandom'

class UrlShortener
  attr_reader :short_to_long, :long_to_short

  def initialize
    @short_to_long = {}
    @long_to_short = {}
  end

  def shorten(url)
    if long_to_short.key?(url)
      long_to_short[url]
    else
      short_url = generate_short_url
      short_to_long[short_url] = url
      long_to_short[url] = short_url
      short_url
    end
  end

  def redirect(short_url)
    short_to_long[short_url]
  end

  private

  def generate_short_url
    SecureRandom.urlsafe_base64(6)
  end
end

# Example usage
url_shortener = UrlShortener.new

original_url = 'https://www.example.com/very/long/url'
shortened_url = url_shortener.shorten(original_url)

puts "Original URL: #{original_url}"
puts "Shortened URL: #{shortened_url}"

redirected_url = url_shortener.redirect(shortened_url)

puts "Redirected URL: #{redirected_url}"
