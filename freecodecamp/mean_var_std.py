import numpy as np

def calculate(input_list):
  if len(input_list) != 9:
    raise ValueError("List must contain nine numbers.")

  matrix = np.array(input_list).reshape(3, 3)
  results = {}

  results['mean'] = [matrix.mean(axis = 0).tolist(), matrix.mean(axis = 1).tolist(), matrix.mean().item()]
  results['variance'] = [matrix.var(axis = 0).tolist(), matrix.var(axis = 1).tolist(), matrix.var().item()]
  results['standard deviation'] = [matrix.std(axis = 0).tolist(), matrix.std(axis = 1).tolist(), matrix.std().item()]
  results['max'] = [matrix.max(axis = 0).tolist(), matrix.max(axis = 1).tolist(), matrix.max().item()]
  results['min'] = [matrix.min(axis = 0).tolist(), matrix.min(axis = 1).tolist(), matrix.min().item()]
  results['sum'] = [matrix.sum(axis = 0).tolist(), matrix.sum(axis = 1).tolist(), matrix.sum().item()]
  
  return results
