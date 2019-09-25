<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Result!</h1>
<h3>Polynomial: ${originalPolForInt.expression}</h3>
<hr />
<p>Integral: ${intPol.expression}</p>
<c:choose>
<c:when test="${area != null}">
<hr />
<p>Area between x = ${originalPolForInt.pointA} and x = ${originalPolForInt.pointB}: &nbsp;&nbsp; ${area}</p>
</c:when>
</c:choose>
<div>
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASkAAACkCAMAAAD8HigCAAAAflBMVEX////l7e8AAP8AAAAzmWbs7P8ICP9kZP8UFP/ExP8cHP8wMP+srP/09P8LCws8PP9UVP94eP+cnP/k5P+kpP9wcP/4+P8sLP+QkP+IiP/Q0P9cXP9QUP9oaP+wsP+goP9ERP/U1P98fP+4uP/AwP84OP/c3P+Vlf+Njf8kJP9Fq6ipAAAErklEQVR4nO3dCXOiMByH4ZgI3uvdWhXv1vb7f8HlEkFC+BNRjPzemXVntXI8Egid7ZQxhBBCCKHC8ao3wJQ4pCQJ749IPsdBlU5IpDikZInoIYqDSpqQQkEqXYYUqFKJGyiGa19GkKJ2O0VgkMooDQUpefWTEsEkMvon9W2S595aSojb6z2BKjVBCHtvqdhj4inlmyRnc693lgqhklLUAZjKaCnZLf/1xfDgENevTJyzimayVPKWX0RFr8e+KJpKah9UJkuxnIPkKpUA1VyZ0VKZ16nLi+wqA6nrWLsdfZCKJbmRjb/oP2L0eUGKmmq3Y9c6wUSkWlcpwmsiOZ2o5XxKvdfy4VbjOXr+awXv+7IyV0p1Ns/8BoI+lMlSqrO5kB9Id0AZLPXsIEUNUtQgRQ1S1CBFDVLUIEUNUtQgRQ1S1CBFDVLUIEXNUClr+vRVmihlTXa28/S1Gic1mK1t3j3sn75is6Q+fKZ5p4p1myQ1Hbd526mEiZkk1RnZfLipbv2GSH1MetxuLavcBCOkvGHX/bKq3QgDpPxh1696K15eKhh2zWbV2/HqUuGwa0BKXTDsGm6QUhRe7RoNSCm7DLsGpJRdhx2kFCWGHaQyuxl2kMooNewgJetjmx52kEq3WdmSYQepm06tNrdXGzkTpC75TGvJ2QlS8Trzrss0G6icIDXot1ymXR5T3aWWX0PbZZpknMMh5WfNVm3Ou86RolRbqY/Tocfdg+n3X5CAlKTB8eAOOd5tHfeNxr/gOUjdNtjMe65Se73YB3t/+fk7SMWa9p1Pzvmns/257j2kku3745179raH4+PNZABSUcuJ452V+Odq0ZHsPaTcrOOi1QuQfs9Ze19zKet0dr7bPDySlJPv2kpZnbMz9I266/F2mX+HUj+p6ek8Hvljjbd387P6QKql1GB/PI/Xnz6R3RuNJ2SjukhZy/5ivu75A423e6PDrEO6y62P1LQz+3J2f3Yg9D2aL/pLLaL3lfrZHlbDQMj+27UO29NP/r7VUmruXs6Go/F5s7RYs1kG0rtKTWP/Sx5S1CBFDVLUIEUNUtQgRe1xUt7fIosNUiySEpAiSoVUkMqX8pQyz1mQYpDSksq+DEKKQUpHSjGzghRLnqcgRZFSztUhxSBVUEp1NodUQirnPhlSDN9LgBSkqEGKGqSoQYoapKhBihqkqEGKGqSoQYoapKhBihqkqEGKGqSoQYoapKhBipr5Ulz3J4XqKKVnVaFUWBVSuXvN767ZvH8ZL1JxYs3PxtQ0neoqpffGsjflxdN0qqOU9hvrJqUdpKhBihqkqF2khOqXeyMWSQl23y81f2wv8SkGUv6mPHd7Cq3thaTY9fFZVSklNMaQLxV+vk89qKqFcne16N4aIlX2BUdjeYWkvE9CY7OyFhScHAlL1BkshCUWq4CU93IpH224IEGGF9FDWT32mCpte6MjhLi5j7jeaH7kJKlSoQrt/QOktM97hG0RZUmJ1CPpHeVCaZ9yCTPP0j7Y2LgrMvrKlCJfSrLem/sVpZzQg1UVWNxDoPR3JZc4POru32IRQF0mCqRJwkvc+JHTmddmLCicJLAXufdFCCGEEEJl9R+sTT1k8+Ja7gAAAABJRU5ErkJggg=="/>
</div>
<h3><a href="isFun">Is integration fun?</a></h3>
</body>
</html>