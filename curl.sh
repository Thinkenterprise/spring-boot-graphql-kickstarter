#!/bin/bash
curl -X POST 'http://localhost:4000/graphql' -H 'Content-Type: application/json' -d '{"query":"{routes{id}}"}'
