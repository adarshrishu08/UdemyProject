package com.udemy.java8.practises;

public class StringParserPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "AdarshRishu";
		Parser parser = new Parser() {
			
			@Override
			public String parse(String str) {
				return StringParser.convert(str);
			}
		};
		Printer printer = new Printer();
		printer.print(str, parser, "Anonymus Class");
		
		Parser parserLambda = s->StringParser.convert(s);
		Printer printerLambda = new Printer();
		printer.print(str, parser, "Lambda");
		
		Parser parserMethodReference = StringParser::convert;
		Printer printerMethodReference = new Printer();
		printer.print(str, parser, "Method Reference");

	}

}


interface Parser{
	String parse(String str);
}

class Printer {
	public void print(String str, Parser p, String PrinterType){
		str = p.parse(str);
		System.out.println(PrinterType+" :: "+str);
	}
}

class StringParser {
	public static String convert(String str){
		if(str.length()<=3)
			str=str.toUpperCase();
		else
			str=str.toLowerCase();
		return str;
	}
}
