# Spring & k8s probes

1. Build Java app
```bash
mvn clean install
```

2. Build Docker image and Push
```bash
docker build -t bitxon/app-long-start:latest .
docker push bitxon/app-long-start:latest
```

3. Deploy to Kubernetes
```bash
kubectl apply -f k8s/app.yaml
```

4. Test your setup
```bash
curl --request GET 'http://localhost:8080/hello'
```

5. Cleanup
```bash
kubectl delete -f k8s/app.yaml
```

# Useful links
[Kubernetes Probes](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/)