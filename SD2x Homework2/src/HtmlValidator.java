import java.util.Queue;
import java.util.Stack;
import java.io.IOException;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stack= new Stack<HtmlTag>();
		while(!tags.isEmpty()) {
			HtmlTag openTag= null;
			HtmlTag tag= tags.remove();
			if(tag.isOpenTag())
				stack.push(tag);
			else if (!tag.isSelfClosing()) {
				if (stack.isEmpty()) {
					return null;
				} 
				openTag = stack.peek();
				if (!tag.matches(openTag)) {
					if (stack.isEmpty()) {
						return null;
					} else
						break;
				} else stack.pop();
			} 
		}
		return stack;
	}
	
	public static void main(String[] args) {
		try{
			Queue<HtmlTag> tags = HtmlReader.getTagsFromHtmlFile("test7.html");
			System.out.print(isValidHtml(tags));
			
		} catch (IOException e) {}
	}

}

