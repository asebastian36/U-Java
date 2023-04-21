# Java web profile

`Full Profile` -> JAX-WS, JAX-RS, JASPIC, JSR 88, JASX-RPC, JAXB, JACC, JSR 77, JAXR, JMS,
JCA, RMI, SAAJ, JAAS, JavaMail, `Web Profile` -> Servlet 3.x, JSP, JSF 2.x, CDI, EJB 3.x,
JTA, JPA 2.x, Bean Validation.

## Comparacion entre EJB y EJB lite

Los componentes predominantes en Java EE son los EJB los cuales agregan de manera muy simple
la transaccionalidad, seguridad, etc. Se puede utilizar el perfil web y utlizar EJB, la
especificacion minima de APIs utilizables en el perfil EJB web se conocen como EJB lite,
las limitaciones de APIs en perfil web son las limitantes que tenemos cuando utilizamos
EJBs por eso el nombre de lite.

| API Soportada | EJB Lite | Full EJB |
|:---:|:---:|:---:|
| **Stateless beans** | X | X |
| **Stateful beans** | X | X |
| **Singleton beans** | X | X |
| **Message driven beans** |  | X |
| **No interfaces** | X | X |
| **Local interfaces** | X | X |
| **Remote interfaces** |  | X |
| **Web service interfaces** |  | X |
| **Asynchronous invocation** |  | X |
| **Interceptors** | X | X |
| **Declarative security** | X | X |
| **Declarative transactions** | X | X |
| **Programmatic transactions** | X | X |

## Empaquetamiento de un EJB

Debido a que una aplicacion Java empresarial incluye distintos tipos de componentes, tales
como servlets, paginas JSF, web services, EJB, etc. Estos componentes deben empaquetarse
para ser desplegados en el servidor de aplicaciones Java, los modulos EJBs se depositan
en:

| empaquetamiento **PersonaApplication.ear** |
|:---:|
| artifact **PersonaServlet.war** PersonaServlet.class `WEB-INF/web.xml` |
| artifact **PersonaEJB.jar** PersonaEJB.class `META-INF/ejb-jar.xml` |
| artifact **PersonaEntity.jar** Persona.class `META-INF/persistence.xml` |

EJB lite puede empaquetarse directamente en un war o en un archivo jar, si los
requerimientos utilizan la especificacion completa de EJB, entonces se debe empaquetar en
un archivo jar y no en un war, un archivo ear es utilizado para empaquetar uno o mas
modulos ya sean jar o war en un arhcivo unico el cual es conocido por el servidor de
aplicaciones y este se encarga de desplegar correctamente cada modulo empaquetado en el
archivo ear.

Si se requiere desplegar una aplicacion web podemos empaquetar los EJB y las clases de
entidad en archivos jar separados, los servlets y paginas JSP o JSF dentro del archivo war
y estos archivos agregarlos a un archivo ear, el cual empaqueta todos los componentes en
uno solo.

| empaquetamiento **PersonaApplication.war** |
|:---:|
| `WEB-INF/classes/PersonaEJB.class` |
| `WEB-INF/classes/Persona.class` |
| `WEB-INF/classes/PersonaServlet.class` |
| `WEB-INF/classes/ejb-jar.xml` |
| `WEB-INF/classes/persistence.xml` |
| `WEB-INF/classes/web.xml` |

## Contenedor embebido de Java EE

Un contenedor embebido tiene como finalidad proveer un ambiente de ejecucion Java EE.
Permite realizar pruebas unitarias de componentes empresariales, la idea del contenedor
embebido es poder ejecutar componentes EJB dentro de aplicaciones Java estandar, permitiendo
utilizar la misma maquina virtual para ejecutar pruebas, procesos de tipo bash, EJB en
aplicaciones de escritorio, etc.

Ejemplo de como ejecutar un contenedor embebido, ademas de utilizar JNDI para encontrar
un EJB y ejecutar un metodo de este EJB:

```Java
public void iniciarContenedorEJB() throws Exception {
    EJBContainer contenedor = EJBContainer.createEJBContainer();
    Context contexto = contenedor.getContext();
    HolaMundoEJB ejb = (HolaMundoEJB) contexto.lookup("java:global/classes/HolaMundoEJB");
    ejb.saluda();
}
```
