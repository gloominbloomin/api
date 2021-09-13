FROM node:16

WORKDIR /app

COPY package*.json ./

# Shell form / starts shell session
RUN npm install
RUN npm build
# RUN npm run watch

COPY . .

# ENV PORT=8080

EXPOSE 8080

# exec form / perferred way
CMD ["npm", "start"] 

# docker build -t name .
# docker run -p 5000:8080 'hash image'
