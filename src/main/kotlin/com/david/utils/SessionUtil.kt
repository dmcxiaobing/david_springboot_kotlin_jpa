package com.david.utils

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

/**
 * session工具类
 *
 */
object SessionUtil {
    /**
     * 全局删除id标示
     */
    var GLOB_DELETE_ID_VAL = "globDeleteIdVal"

    /**
     * 获取request
     *
     * @return
     */
    val request: HttpServletRequest?
        get() {
            val requestAttributes = RequestContextHolder
                    .getRequestAttributes() as ServletRequestAttributes
            return requestAttributes?.request
        }

    /**
     * 获取session
     *
     * @return
     */
    val session: HttpSession
        get() = request!!.getSession(false)

    /**
     * 获取真实路径
     *
     * @return
     */
    val realRootPath: String
        get() = request!!.servletContext.getRealPath("/")

    /**
     * 获取ip
     *
     * @return
     */
    val ip: String?
        get() {
            val servletRequestAttributes = RequestContextHolder
                    .getRequestAttributes() as ServletRequestAttributes
            if (servletRequestAttributes != null) {
                val request = servletRequestAttributes.request
                return request.remoteAddr
            }
            return null
        }

    /**
     * 获取上下文path
     *
     * @return
     */
    val contextPath: String
        get() = request!!.contextPath

    /**
     * 获取session中的Attribute
     *
     * @param name
     * @return
     */
    fun getSessionAttribute(name: String): Any? {
        val request = request
        return request?.session?.getAttribute(name)
    }

    /**
     * 设置session的Attribute
     *
     * @param name
     * @param value
     */
    fun setSessionAttribute(name: String, value: Any) {
        val request = request
        request?.session?.setAttribute(name, value)
    }

    /**
     * 获取request中的Attribute
     *
     * @param name
     * @return
     */
    fun getRequestAttribute(name: String): Any? {
        val request = request
        return request?.getAttribute(name)
    }

    /**
     * 设置request的Attribute
     *
     * @param name
     * @param value
     */
    fun setRequestAttribute(name: String, value: Any) {
        val request = request
        request?.setAttribute(name, value)
    }

    /**
     * 删除session中的Attribute
     *
     * @param name
     */
    fun removeSessionAttribute(name: String) {
        request!!.session.removeAttribute(name)
    }

}