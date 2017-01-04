import cv2
import numpy

def rmse(predictions, targets):
	return numpy.sqrt(numpy.mean((numpy.array(predictions)-numpy.array(targets))**2))

a = [[1 ,2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
rotated = a
final = rotated
min_rmse = rmse(rotated, a)
for i in xrange(3):
	rotated = numpy.rot90(rotated, 1)
	curr_rmse = rmse(rotated, a)
	print min_rmse, curr_rmse
	if curr_rmse > min_rmse:
		min_rmse = curr_rmse
		final = rotated
print final