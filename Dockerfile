FROM openjdk:8
FROM openjdk:8
RUN curl -u admin:vagrant -o ExamThourayaS2-1.0.jar "http://192.168.43.225:8081/repository/maven-releases/tn/esprit/exam/ExamThourayaS2/1.0/ExamThourayaS2-1.0.jar" -L
CMD ["java","-jar","ExamThourayaS2-0.0.1-SNAPSHOT.jar"]