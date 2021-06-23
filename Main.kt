package seamcarving

import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.IIOException
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    topic2(args)
}

fun topic1() {
    val scanner = Scanner(System.`in`)

    println("Enter rectangle width:")
    val width: Int = scanner.nextInt()

    println("Enter rectangle height:")
    val height: Int = scanner.nextInt()

    println("Enter output image name:")
    val outputImageName: String = scanner.next()

    val image: BufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val graphics: Graphics = image.graphics

    graphics.color = Color(255, 0, 0)
    graphics.drawLine(0, 0, width - 1, height - 1)
    graphics.drawLine(0, height - 1, width - 1, 0)

    ImageIO.write(image, "png", File(outputImageName))
}

fun topic2(args: Array<String>) {
    var inputImageName: String? = null
    var outputImageName: String? = null

    for (argumentIndex in args.indices) {
        when(args[argumentIndex]) {
            "-in" -> {
                inputImageName = args[argumentIndex + 1]
            }
            "-out" -> {
                outputImageName = args[argumentIndex + 1]
            }
        }
    }

    if (inputImageName == null || outputImageName == null) {
        return
    }

    try {
        val inputImage: BufferedImage = ImageIO.read(File(inputImageName))
        val graphics: Graphics = inputImage.graphics

        for (x in 0 until inputImage.width) {
            for (y in 0 until inputImage.height) {
                val pixelColor: Color = Color(inputImage.getRGB(x, y))
                inputImage.setRGB(x, y, 256 * 256 * (255 - pixelColor.red) + 256 * (255 - pixelColor.green) + 255 - pixelColor.blue)
            }
        }

        ImageIO.write(inputImage, "png", File(outputImageName))
    } catch (e: IIOException) {
        print(e.message)
    }
}