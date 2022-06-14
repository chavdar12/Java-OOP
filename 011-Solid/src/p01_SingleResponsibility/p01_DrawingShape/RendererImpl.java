package src.p01_SingleResponsibility.p01_DrawingShape;

import src.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import src.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class RendererImpl implements Renderer {
    @Override
    public void render(Shape shape) {
        System.out.println("draw shape");
    }
}
