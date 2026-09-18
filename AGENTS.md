# INSTRUÇÕES DO SOFTWARE

- O software é um sistema web de e-commerce para feira digital feito em Java + Spring-boot + JPA + hibernate;
- Leia o arquivo 'pom.xml'

### Objetivo
- criar um portifólio robusto para demonstrar minhas habilidades em desenvolvimento e aprender;

## Decisões de arquitetura

- Camadas, separadas por *Entity*, *service*, *controller*, *DTO* e *repository*;
- Separação de responsabilidades entre serviços, controladores e entidades;
- Desenvolvimento voltado para simplicidade, mas, robustez

## Padrão de desenvolvimento
- Espaços entre declaração do método e chave delimitadora final. Exemplo:
  
  ```
    public void metodo(){
        //espaço em branco
        //código
        //espaço em branco
    }
  ```

- Priorize desenvolver sempre partindo da entidade (entity) até as camadas mais externas (controller);
- Usar exceções personalizadas e, caso não exista ainda uma específica, crie uma.

### Execução
- usar comando `mvn spring-boot:run` na pasta raiz para rodar o software

## Comentários
- Em caso de erros, marcar um comentário ao lado de onde ocorreu e informar a exceção;
- Sugerir recomendações de correção;
- **Não** tente fazer correções no código, a menos que eu permita;

## Referências e notas

- obter imagem de UML no caminho "A:\Projects\Software Development\Efair engineering\uml-images"