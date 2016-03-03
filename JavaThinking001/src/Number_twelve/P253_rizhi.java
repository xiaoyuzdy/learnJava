package Number_twelve;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 异常与日志文件
 * 
 * @author he
 * 
 */

class loggerException extends Exception {
	// logger对象用来记录特定系统或应用程序组件的日志消息
	
	// 为指定子系统查找或创建一个 logger。
	private Logger logger = Logger.getLogger("loggerException");

	public loggerException() {
		// 字符流对象
		StringWriter trace = new StringWriter();
		// 指定文件创建不具有自动刷新,显示出错的位置
		printStackTrace(new PrintWriter(trace));
		// 记录一条sever消息
		logger.severe(trace.toString());
	}

}

public class P253_rizhi {

	public static void main(String[] args) {
		try {
			throw new loggerException();
		} catch (loggerException e) {
			System.err.println("Caught 1   " + e);
		}

		try {
			throw new loggerException();
		} catch (loggerException e) {
			System.err.println("Caught 2   " + e);
		}

	}

}
