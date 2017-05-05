/**
 * @author drsantos on May 5, 2017
 */
package com.devopsbuddy.exceptions;

/**
 * @author drsantos
 *
 */
public class S3Exception extends RuntimeException {

    public S3Exception(Throwable e) {
        super(e);
    }

    public S3Exception(String s) {
        super(s);
    }
}
