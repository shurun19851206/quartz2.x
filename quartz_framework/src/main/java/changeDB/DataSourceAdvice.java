package changeDB;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/**
 * 
  * ClassName: DataSourceAdvice
  * Description: TODO
  * @date 2015��4��23�� ����12:49:04
  *
 */
public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	/**
	  * Title: before
	  * Description: service����ִ��֮ǰ������  
	  * @param method Method
	  * @param args Object[]
	  * @param target Object
	  * @throws Throwable    �趨�ļ�
	  * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	  * @throws Throwable Throwable
	 */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (method.getName().endsWith("Slave")) {
            DataSourceSwitcher.setSlave("Slave");
        } else {
            return ;
            // DataSourceSwitcher.clearDataSource();
        }
    }
  
    /**
      * Title: afterReturning
      * Description: service����ִ����֮�󱻵���  
      * @param arg0 Object
      * @param method Method
      * @param args Object[]
      * @param target Object
      * @throws Throwable    �趨�ļ�
      * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
      * @throws Throwable Throwable
     */
    public void afterReturning(Object arg0, Method method, Object[] args, Object target) throws Throwable {  
        DataSourceSwitcher.clearDataSource();
    }  
  
    /**
      * <p>
      * Title: afterThrowing <br>
      * Description: �׳�Exception֮�󱻵���  
      * @param method Method
      * @param args Object[]
      * @param target Object
      * @param ex Exception
      * @throws Throwable    �趨�ļ�  <br>
      * void    ��������  <br>
      * @throws Throwable Throwable
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {  
        DataSourceSwitcher.clearDataSource();
    }
}