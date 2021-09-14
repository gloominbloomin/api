FROM node:16

WORKDIR /app

COPY package*.json ./

# Shell form / starts shell session
RUN npm install
# RUN npm run build
# RUN npm install -g typescript
# RUN npm install -g tsc \
#  && npm install -g concurrently \ 
# && npm install -g typescript \

# RUN npm run build
# RUN npm run watch

COPY . .

# ENV PORT=8080

EXPOSE 8080

# exec form / perferred way
CMD ["npm", "start"] 
# CMD ["npm", "build", "start"] 

# docker build -t name .
# docker run -p 5000:8080 'hash image'
