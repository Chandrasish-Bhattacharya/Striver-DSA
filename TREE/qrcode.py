import qrcode

# Step 1: Define the data you want to encode
data = "https://www.example.com"

# Step 2: Create a QRCode object with desired settings
qr = qrcode.QRCode(
    version=1,  # Controls the size of the QR Code (1 is smallest)
    error_correction=qrcode.constants.ERROR_CORRECT_H,  # High error correction
    box_size=10,  # Size of each box in pixels
    border=4,  # Thickness of the border (minimum is 4)
)

# Step 3: Add data to the QR code
qr.add_data(data)
qr.make(fit=True)

# Step 4: Create an image from the QR code
img = qr.make_image(fill_color="black", back_color="white")

# Step 5: Save the image
img.save("my_qr_code.png")

print("QR code generated and saved as 'my_qr_code.png'")