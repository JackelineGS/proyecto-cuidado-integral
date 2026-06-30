package com.argos.proyectocuidadointegral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ProductoExceptionHandler {

    @ExceptionHandler(ProductoNotFoundException.class)
    public ModelAndView handleProductoNotFound(ProductoNotFoundException ex) {
        ModelAndView mav = new ModelAndView("error/producto-no-encontrado");
        mav.addObject("mensaje", ex.getMessage());
        mav.setStatus(HttpStatus.NOT_FOUND);
        return mav;
    }
    @ExceptionHandler(StockInsuficienteException.class)
    public ModelAndView handleStockInsuficiente(StockInsuficienteException ex) {
        ModelAndView mav = new ModelAndView("error/stock-insuficiente");
        mav.addObject("mensaje", ex.getMessage());
        mav.setStatus(HttpStatus.BAD_REQUEST);
        return mav;
    }
}
