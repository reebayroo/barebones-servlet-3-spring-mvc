package com.reebayroo.web.controllers;

import org.springframework.web.servlet.ModelAndView;

public class ViewUtil {

	public static ModelAndView addMessage(final ModelAndView modelAndView, final String message, final Object... args) {

		modelAndView.addObject("message", String.format(message, args));
		return modelAndView;
	}

	public static ModelAndView addError(final ModelAndView modelAndView, final String message, final Object... args) {

		modelAndView.addObject("error", String.format(message, args));
		return modelAndView;
	}

	public static ModelAndView redirect(final String url, final Object... args) {
		return new ModelAndView( "redirect:".concat(String.format(url, args)));
	}

	public static ModelAndView addWarning(final ModelAndView modelAndView, final String message, final Object... args) {
		modelAndView.addObject("warning", String.format(message, args));
		return modelAndView;
	}


	public static ModelAndView addSuccessMessage(final ModelAndView view) {
		return addMessage(view, "Record saved with success.");
	}


}
