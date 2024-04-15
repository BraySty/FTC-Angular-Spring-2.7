import { HttpInterceptor, HttpInterceptorFn } from "@angular/common/http";

export const CustomInterceptor:HttpInterceptorFn = (req, next) => {

    const token = localStorage.getItem("token")
    if (token?.length != null) {
        const cloneRequest = req.clone( {
            setHeaders: {
                Authorization: `Bearer ${token}`
            }
        });
        return next(cloneRequest);
    } else {
        return next(req);
    }
}