FROM node:9.6.1
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

RUN mkdir /usr/src/app
WORKDIR /usr/src/app

ENV PATH /usr/src/app/node_modules/.bin:$PATH

COPY package.json /usr/src/app/package.json
RUN npm install

CMD ["npm", "start"]
