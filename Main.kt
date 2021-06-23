package seamcarving

import java.awt.Color
import java.awt.Graphics
import java.util.*
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
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
