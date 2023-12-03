package com.myProject.project.common.libs;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    public BaseController() {
    }

    public static <T> ResponseEntity<T> ok() {
        return new ResponseEntity(HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> continueRes(T object) {
        return new ResponseEntity(object, HttpStatus.CONTINUE);
    }

    public static <T> ResponseEntity<T> switchingProtocols(T object) {
        return new ResponseEntity(object, HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static <T> ResponseEntity<T> processing(T object) {
        return new ResponseEntity(object, HttpStatus.PROCESSING);
    }

    public static <T> ResponseEntity<T> checkpoint(T object) {
        return new ResponseEntity(object, HttpStatus.CHECKPOINT);
    }

    public static <T> ResponseEntity<T> ok(T object) {
        return new ResponseEntity(object, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> created() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> created(T object) {
        return new ResponseEntity(object, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> accepted() {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<T> accepted(T object) {
        return new ResponseEntity(object, HttpStatus.ACCEPTED);
    }

    public static <T> ResponseEntity<T> nonAuthoritativeInformation(T object) {
        return new ResponseEntity(object, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static <T> ResponseEntity<T> noContent() {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<T> noContent(T object) {
        return new ResponseEntity(object, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<T> resetContent(T object) {
        return new ResponseEntity(object, HttpStatus.RESET_CONTENT);
    }

    public static <T> ResponseEntity<T> partialContent(T object) {
        return new ResponseEntity(object, HttpStatus.PARTIAL_CONTENT);
    }

    public static <T> ResponseEntity<T> multiStatus(T object) {
        return new ResponseEntity(object, HttpStatus.MULTI_STATUS);
    }

    public static <T> ResponseEntity<T> alreadyReported(T object) {
        return new ResponseEntity(object, HttpStatus.ALREADY_REPORTED);
    }

    public static <T> ResponseEntity<T> imUsed(T object) {
        return new ResponseEntity(object, HttpStatus.IM_USED);
    }

    public static <T> ResponseEntity<T> multipleChoices(T object) {
        return new ResponseEntity(object, HttpStatus.MULTIPLE_CHOICES);
    }

    public static <T> ResponseEntity<T> movedPermanently(T object) {
        return new ResponseEntity(object, HttpStatus.MOVED_PERMANENTLY);
    }

    public static <T> ResponseEntity<T> found(T object) {
        return new ResponseEntity(object, HttpStatus.FOUND);
    }

    public static <T> ResponseEntity<T> seeOther(T object) {
        return new ResponseEntity(object, HttpStatus.SEE_OTHER);
    }

    public static <T> ResponseEntity<T> notModified() {
        return new ResponseEntity((Object) null, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<T> notModified(T object) {
        return new ResponseEntity(object, HttpStatus.NOT_MODIFIED);
    }

    public static <T> ResponseEntity<T> temporaryRedirect(T object) {
        return new ResponseEntity(object, HttpStatus.TEMPORARY_REDIRECT);
    }

    public static <T> ResponseEntity<T> permanentRedirect(T object) {
        return new ResponseEntity(object, HttpStatus.PERMANENT_REDIRECT);
    }

    public static <T> ResponseEntity<T> badRequest(T object) {
        return new ResponseEntity(object, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<T> unauthorized(T object) {
        return new ResponseEntity(object, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<T> paymentRequired(T object) {
        return new ResponseEntity(object, HttpStatus.PAYMENT_REQUIRED);
    }

    public static <T> ResponseEntity<T> forbidden(T object) {
        return new ResponseEntity(object, HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<T> notFound(T object) {
        return new ResponseEntity(object, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<T> methodNotAllowed(T object) {
        return new ResponseEntity(object, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static <T> ResponseEntity<T> notAcceptable(T object) {
        return new ResponseEntity(object, HttpStatus.NOT_ACCEPTABLE);
    }

    public static <T> ResponseEntity<T> proxyAuthenticationRequired(T object) {
        return new ResponseEntity(object, HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<T> requestTimeout(T object) {
        return new ResponseEntity(object, HttpStatus.REQUEST_TIMEOUT);
    }

    public static <T> ResponseEntity<T> conflict(T object) {
        return new ResponseEntity(object, HttpStatus.CONFLICT);
    }

    public static <T> ResponseEntity<T> gone(T object) {
        return new ResponseEntity(object, HttpStatus.GONE);
    }

    public static <T> ResponseEntity<T> lengthRequired(T object) {
        return new ResponseEntity(object, HttpStatus.LENGTH_REQUIRED);
    }

    public static <T> ResponseEntity<T> preconditionFailed(T object) {
        return new ResponseEntity(object, HttpStatus.PRECONDITION_FAILED);
    }

    public static <T> ResponseEntity<T> payloadTooLarge(T object) {
        return new ResponseEntity(object, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static <T> ResponseEntity<T> uriTooLong(T object) {
        return new ResponseEntity(object, HttpStatus.URI_TOO_LONG);
    }

    public static <T> ResponseEntity<T> unsupportedMediaType(T object) {
        return new ResponseEntity(object, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static <T> ResponseEntity<T> requestedRangeNotSatisfiable(T object) {
        return new ResponseEntity(object, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static <T> ResponseEntity<T> expectationFailed(T object) {
        return new ResponseEntity(object, HttpStatus.EXPECTATION_FAILED);
    }

    public static <T> ResponseEntity<T> iAmATeapot(T object) {
        return new ResponseEntity(object, HttpStatus.I_AM_A_TEAPOT);
    }

    public static <T> ResponseEntity<T> unprocessableEntity(T object) {
        return new ResponseEntity(object, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<T> locked(T object) {
        return new ResponseEntity(object, HttpStatus.LOCKED);
    }

    public static <T> ResponseEntity<T> failedDependency(T object) {
        return new ResponseEntity(object, HttpStatus.FAILED_DEPENDENCY);
    }

    public static <T> ResponseEntity<T> upgradeRequired(T object) {
        return new ResponseEntity(object, HttpStatus.UPGRADE_REQUIRED);
    }

    public static <T> ResponseEntity<T> preconditionRequired(T object) {
        return new ResponseEntity(object, HttpStatus.PRECONDITION_REQUIRED);
    }

    public static <T> ResponseEntity<T> tooManyRequests(T object) {
        return new ResponseEntity(object, HttpStatus.TOO_MANY_REQUESTS);
    }

    public static <T> ResponseEntity<T> requestHeaderFieldsTooLarge(T object) {
        return new ResponseEntity(object, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static <T> ResponseEntity<T> internalServerError(T object) {
        return new ResponseEntity(object, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<T> notImplemented(T object) {
        return new ResponseEntity(object, HttpStatus.NOT_IMPLEMENTED);
    }

    public static <T> ResponseEntity<T> badGateway(T object) {
        return new ResponseEntity(object, HttpStatus.BAD_GATEWAY);
    }

    public static <T> ResponseEntity<T> serviceUnavailable(T object) {
        return new ResponseEntity(object, HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static <T> ResponseEntity<T> gatewayTimeout(T object) {
        return new ResponseEntity(object, HttpStatus.GATEWAY_TIMEOUT);
    }

    public static <T> ResponseEntity<T> httpVersionNotSupported(T object) {
        return new ResponseEntity(object, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static <T> ResponseEntity<T> variantAlsoNegotiates(T object) {
        return new ResponseEntity(object, HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static <T> ResponseEntity<T> insufficientStorage(T object) {
        return new ResponseEntity(object, HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static <T> ResponseEntity<T> loopDetected(T object) {
        return new ResponseEntity(object, HttpStatus.LOOP_DETECTED);
    }

    public static <T> ResponseEntity<T> bandwidthLimitExceeded(T object) {
        return new ResponseEntity(object, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static <T> ResponseEntity<T> notExtended(T object) {
        return new ResponseEntity(object, HttpStatus.NOT_EXTENDED);
    }

    public static <T> ResponseEntity<T> networkAuthenticationRequired(T object) {
        return new ResponseEntity(object, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    public static <T> ResponseEntity<T> redirect(String externalurl) throws URISyntaxException {
        URI yahoo = new URI(externalurl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(yahoo);
        return new ResponseEntity(httpHeaders, HttpStatus.SEE_OTHER);
    }

    public static <T> RestResponse<T> newRestResponse(T data) {
        return newRestResponse(data, true, (String) null);
    }

    protected static <T> RestResponse<T> newRestResponse(T data, String errorMessage) {
        return newRestResponse(data, true, errorMessage);
    }

    protected static <T> RestResponse<T> newRestResponse(T data, boolean status) {
        return newRestResponse(data, status, (String) null);
    }

    //protected static <T> RestResponse<T> newRestResponse(boolean status, String errorMessage) {
    //    return newRestResponse((Object) null, status, errorMessage);
    //}

    protected static <T> RestResponse<T> errorResponse(List<FieldError> fieldErrors) {
        return new RestResponse((Object) null, false, getErrors(fieldErrors));
    }

    protected static <T> RestResponse<T> errorResponse(String errorMessage, String errorCode) {
        return new RestResponse((Object) null, false, errorMessage, errorCode);
    }

    protected static <T> RestResponse<T> errorResponse(String errorMessage, String errorCode,
        Map<String, Object> meta) {
        return new RestResponse((Object) null, false, errorMessage, errorCode, meta);
    }

    protected static <T> RestResponse<T> newRestResponse(T data, boolean status, String errorMessage) {
        return new RestResponse(data, status, errorMessage);
    }

    protected static <T> RestResponse<T> newRestResponse(T data, boolean status, String errorMessage,
        String errorCode) {
        return new RestResponse(data, status, errorMessage, errorCode);
    }

    protected static String getErrors(List<FieldError> fieldErrors) {
        StringBuffer buffer = new StringBuffer();
        String prefix = "";
        Iterator var3 = fieldErrors.iterator();

        while (var3.hasNext()) {
            FieldError error = (FieldError) var3.next();
            buffer.append(prefix);
            prefix = " , ";
            buffer.append(error.getDefaultMessage());
        }

        return buffer.toString();
    }

    protected static String getConstraintViolationErrors(ConstraintViolationException ex) {
        StringBuffer buffer = new StringBuffer();
        //String prefix = "";
        buffer.append(ex.getConstraintName());
        //Iterator var3 = ex.getConstraintViolations().iterator();
        //
        //while (var3.hasNext()) {
        //    ConstraintViolation<?> violation = (ConstraintViolation) var3.next();
        //    buffer.append(prefix);
        //    prefix = " , ";
        //    buffer.append(violation.getMessage());
        //}

        return buffer.toString();
    }
}
