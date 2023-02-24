# Cabeceros de respuesta con servlets

Los cabeceros de respuesta se utilizan para indicar al navegador web como debe comportarse ante una respuesta de parte del
servidor web.

Un ejemplo comun es generar hojas de excel, PDF's, audio, video, etc, en lugar de solamente responder con texto.

Para indicar el tipo de respuesta se utilizan los tipos MIME (Multipurpose Internet Mail Extensions).

Los tipos MIME son un conjunto de especificaciones con el objetivo de intercambiar archivos a traves de internet como puede
ser texto, audio, video, entre otros tipos.

## Ejemplos mas comunes de tipos MIME

* Primero se especifica el nombre del tipo MIME (del lado del servidor).
  * application/msword | Microsoft word document.
  * application/pdf | acrobat (.pdf) file.
  * application/vnd.ms-excel | Excel spreadsheet.
  * application/vnd.ms-powerpoint | Powerpoint presentation.
  * application/zip | Zip archive.
  * audio/x-wav | Microsoft Windows sound file.
  * text/css | HTML cascading style sheet.
  * text/html | HTML document.
  * text/xml | XML document.
  * image/gif | GIF image.
  * image/jpeg | JPEG image.
  * image/png | PNG image.
  * video/mpeg | MPEG video clip.
  * video/quicktime | QuickTime video clip.

## API de servlets al utilizar cabeceros de respuesta

**Metodos para Establecer valores de los Headers:**

* `response.setHeader(String nombreCabecero, String valorCabecero)`
* `setDateHeader()`
* `setIntHeader()`
  * Estos metodos ponen un cabecero, y si ya existe lo reemplazan.
* `response.addHeader`, `addDateHeader` y `addIntHeader` agregan nuevos valores en lugar de reemplazarlos.

## Metodos mas comunes para establecer valores de los headers

* `setContentType` (Se utliza la tabla MIME para definir su valor).
* `setContentLenght`
* `addCookie`
* `sendRedirect`

## Cabeceros de respuesta mas comunes

* Cache-Control y Pragma: Se usan para el control del cache.
* Content-Encoding: Indica la codificacion del documento.
* Content-Lenght: Indica el numero de bytes en la respuesta.
* Content-Type: Indica el tipo MIME a responder.
* Expires: Indica el tiempo en que el documento se considera expirado.
* Last-Modified: Indica el tiempo en que el documento fue modificado.
* Refresh: Indica los segundos en que el navegador recarga la pagina.
* Set-Cookie: Agrega una cookie al navegador.
* WWW-Authenticate: Indica el tipo de autentificacion.
