#!/usr/bin/env python3

'''
Testing how many threads is optimal. 
Time was taken from before threads start to right before we disconnect from _hlaWorld.

"the lists contain the total time (ms) it took N threads to calculate 39800 x 100 paths, the average time is ..."

- BLOCK_SIZE: 1
- threads: 1 .. 
- Radio l=0.002
- MAX_HOPS=4
- 39800 requests
- 200 noder
- distance heur
- randomized radioCom (but same resulting graph)

avg for 1 thread(s) = 18424.03
avg for 2 thread(s) = 9006.85
avg for 3 thread(s) = 6356.56
avg for 4 thread(s) = 5168.92
avg for 5 thread(s) = 5010.63
avg for 6 thread(s) = 4865.5
avg for 7 thread(s) = 4788.39
avg for 8 thread(s) = 4708.94
avg for 9 thread(s) = 4746.56
avg for 10 thread(s) = 4714.41
avg for 11 thread(s) = 4732.58
'''

# results is [[t1],[t2], ... [tn]]
results = [
    [18756, 18716, 18922, 17969, 18801, 18802, 17801, 19220, 18467, 18492, 17717, 18452, 19177, 18825, 19486, 18478, 18599, 17690, 17935, 18710, 18771, 18538, 18701, 18482, 18809, 18485, 18520, 18510, 18333, 18503, 18526, 17557, 18550, 18368, 18536, 18454, 18701, 17683, 18464, 18496, 18521, 19196, 18524, 18443, 17683, 18228, 17739, 18448, 18717, 20017, 18769, 19498, 18964, 19448, 19543, 18449, 20314, 20639, 20726, 19013, 19712, 18818, 19553, 20362, 19880, 19150, 20474, 20147, 18786, 17910, 17728, 17835, 18166, 17359, 18344, 18579, 17923, 16973, 17515, 17561, 16764, 17639, 16820, 17552, 17861, 16727, 17595, 17581, 17835, 17567, 17700, 17533, 17966, 17147, 17013, 17949, 17614, 17800, 17070, 17014],
    [9129, 9256, 8939, 9104, 9190, 8877, 8232, 9086, 9173, 9196, 9450, 8224, 8043, 8937, 9087, 9529, 9295, 9015, 9363, 9097, 8957, 8261, 8650, 9017, 9221, 9118, 9698, 9594, 9825, 9077, 8948, 9618, 9017, 9153, 9349, 9268, 8925, 9036, 8961, 8976, 8883, 9280, 8201, 9183, 9345, 9444, 9282, 8248, 9142, 7980, 8238, 9050, 9204, 9054, 9044, 9079, 8928, 9546, 9139, 8870, 9232, 9029, 9399, 9047, 9000, 8308, 8157, 9139, 8363, 8932, 9052, 9387, 9008, 9447, 9461, 8213, 9287, 9427, 9100, 9529, 9489, 9067, 9166, 8341, 8989, 9359, 8992, 9223, 8316, 9176, 8938, 9163, 8054, 9016, 8847, 9331, 8306, 8914, 8335, 9115],
    [6424, 6486, 6194, 6451, 6352, 5948, 5864, 6371, 6431, 6463, 6273, 6465, 6555, 6587, 6446, 6326, 6288, 6441, 5784, 6323, 6397, 6361, 6394, 6549, 6428, 6365, 6466, 6474, 6313, 6469, 6340, 6351, 6590, 6462, 6413, 6351, 6404, 6408, 5763, 6437, 6333, 6489, 6384, 5833, 6391, 6531, 6286, 6450, 5675, 6372, 6224, 6437, 6684, 6381, 6721, 6273, 6435, 6522, 5853, 6714, 6539, 6442, 6296, 6442, 6265, 6414, 6297, 5832, 6500, 6571, 6508, 6493, 5922, 6464, 6390, 6181, 6465, 6513, 6474, 6291, 6419, 6588, 6443, 5621, 6583, 6489, 6513, 6424, 6408, 6254, 6275, 6428, 6435, 6499, 6511, 6448, 6299, 6351, 6353, 5821],
    [5473, 5154, 5135, 5290, 5279, 5575, 5188, 5194, 5245, 4508, 5258, 5413, 5174, 5183, 5135, 5172, 5249, 5228, 5112, 5044, 5121, 5171, 5198, 5178, 5261, 6119, 5138, 5328, 5145, 5219, 5324, 5275, 5106, 5164, 5153, 5170, 5140, 5302, 5271, 5088, 5251, 5169, 5268, 5220, 5246, 5321, 5193, 4852, 4889, 5227, 5270, 5255, 4840, 5272, 5286, 5311, 5162, 4858, 5369, 5125, 5167, 5065, 5157, 5073, 5130, 5175, 5188, 4762, 4689, 5118, 5059, 5132, 4773, 5190, 5339, 5189, 5114, 5190, 5282, 5144, 5119, 5185, 4845, 5166, 5120, 5066, 5156, 5071, 5178, 5311, 5128, 5101, 5073, 5172, 5238, 5009, 5169, 5177, 5240, 5168],
    [5013, 5009, 4963, 5107, 4969, 4687, 5013, 5168, 4495, 4995, 5019, 5021, 4958, 5095, 4993, 4966, 5092, 4995, 5016, 4999, 5053, 5098, 4993, 5109, 5086, 5045, 4998, 5051, 5058, 5012, 4984, 4664, 5043, 5042, 5067, 5073, 5982, 6300, 6103, 4983, 4698, 4961, 5001, 5017, 4953, 4978, 5065, 4999, 4638, 5180, 4999, 4792, 5003, 5077, 4944, 4975, 5263, 5248, 5179, 5050, 4614, 5067, 4865, 4537, 5036, 5255, 5026, 4996, 4632, 4527, 5073, 5163, 5180, 4633, 5087, 4960, 5137, 5031, 5099, 5217, 4568, 4950, 5043, 5048, 5020, 5050, 4973, 4874, 4555, 4974, 4621, 4997, 5110, 5090, 5081, 4935, 4652, 5071, 5097, 4882],
    [4924, 4880, 4952, 4895, 4895, 5048, 4881, 4938, 4854, 5069, 4842, 4976, 4933, 4973, 4899, 4894, 5012, 5034, 4439, 4902, 4856, 4923, 4945, 4842, 4977, 4839, 4940, 5042, 4879, 4864, 4797, 4495, 4915, 4865, 4921, 4949, 4964, 4735, 4858, 4875, 4892, 4879, 4741, 4921, 4489, 4813, 4511, 4884, 4975, 4905, 4886, 4946, 4896, 4998, 4437, 4837, 4964, 4905, 5055, 4922, 4876, 4830, 4967, 4962, 4852, 4847, 4926, 4946, 4968, 4965, 4420, 4902, 4922, 4869, 4866, 4875, 4970, 4470, 4912, 4848, 4921, 4430, 4893, 4865, 4992, 4903, 4927, 4872, 4880, 4877, 4919, 4848, 4987, 4822, 4437, 4880, 4982, 4899, 4946, 4500],
    [4872, 4849, 4898, 4765, 4807, 4867, 4837, 4873, 4847, 4909, 4906, 4790, 4821, 4866, 4976, 4905, 4859, 4900, 4759, 4882, 4925, 4815, 4654, 4914, 4807, 4800, 4858, 4817, 4844, 4751, 4926, 4742, 4941, 4872, 4755, 4753, 4436, 4827, 4484, 4727, 4881, 4801, 4816, 4929, 4854, 4803, 4766, 4480, 4887, 4391, 5053, 4790, 4845, 4390, 4570, 4858, 4818, 4824, 4804, 4836, 4917, 4358, 4814, 4862, 4851, 4851, 4299, 4847, 4800, 4852, 4776, 4771, 4749, 4876, 4426, 4766, 5028, 4915, 4801, 4802, 4296, 4769, 4852, 4746, 4843, 4859, 4841, 4867, 4440, 4862, 4798, 4513, 4808, 4816, 4789, 4813, 4843, 4805, 4926, 4760],
    [4749, 4741, 4334, 4798, 4697, 4807, 4742, 4709, 4264, 4769, 4853, 4820, 4776, 4928, 4964, 4824, 4931, 4778, 4905, 4897, 4693, 4749, 4737, 4808, 4795, 4964, 4853, 4729, 4785, 4651, 4785, 4807, 4744, 4785, 4341, 4723, 4804, 4741, 4960, 4927, 4845, 4426, 4676, 4649, 4709, 4720, 4567, 4748, 4647, 4235, 4843, 4724, 4768, 4771, 4792, 4752, 4804, 4659, 4583, 4776, 4585, 4791, 4649, 4710, 4727, 4790, 4651, 4416, 4778, 4660, 4722, 4730, 4775, 4795, 4722, 4763, 4735, 4685, 4796, 4719, 4160, 4750, 4242, 4796, 4763, 4703, 4656, 4782, 4687, 4184, 4594, 4812, 4743, 4797, 4297, 4753, 4259, 4803, 4843, 4710],
    [4783, 4885, 4781, 4752, 4856, 4727, 4796, 4781, 4657, 4743, 4777, 4739, 4712, 4760, 4812, 4830, 4390, 4765, 4673, 4868, 4642, 4731, 4784, 4718, 4730, 4814, 4724, 4795, 4699, 4732, 4754, 4741, 4789, 4721, 4755, 4803, 4696, 4695, 4732, 4783, 4803, 4312, 4656, 4831, 4730, 4755, 4830, 4826, 4952, 4692, 4832, 4777, 4820, 4846, 4824, 4743, 4889, 4803, 4661, 4831, 4809, 4840, 4762, 4688, 4275, 4787, 4128, 4778, 4762, 4763, 4713, 4758, 4764, 4882, 4287, 4788, 4735, 4740, 4842, 4823, 4715, 4816, 4782, 4711, 4700, 4643, 4603, 4767, 4757, 4715, 4216, 4863, 4862, 5093, 4616, 5052, 5141, 4787, 4747, 4808],
    [4776, 4779, 4824, 4821, 4781, 4692, 4688, 4755, 4436, 4800, 4842, 4665, 4143, 4720, 4321, 4822, 4844, 4794, 4693, 4789, 4906, 4840, 4791, 4757, 4765, 4627, 4768, 4706, 4733, 4765, 4794, 4750, 4732, 4886, 4668, 4722, 4795, 4680, 4710, 4392, 4747, 4795, 4656, 4831, 4750, 4768, 4718, 4215, 4446, 4740, 4353, 5068, 4738, 4913, 4854, 4764, 4725, 4795, 4731, 4772, 4872, 4872, 4776, 4754, 4797, 4763, 4692, 4727, 4818, 4770, 4737, 4741, 4263, 4420, 4229, 4815, 4722, 4830, 4841, 4867, 4271, 4760, 4755, 4860, 4757, 4770, 4705, 4767, 4814, 4769, 4321, 4668, 4814, 4704, 4821, 4279, 4770, 4751, 4771, 4857],
    [4751, 4767, 4832, 4732, 4679, 4364, 4856, 4216, 4867, 4666, 4894, 4883, 4783, 4397, 4847, 5033, 4834, 4914, 4425, 4761, 4849, 4882, 4798, 4748, 4730, 4356, 4155, 4847, 4637, 4788, 4893, 4799, 4694, 4816, 4514, 4838, 4818, 4816, 4717, 4747, 4840, 4739, 4637, 4788, 4897, 4764, 4844, 4735, 4729, 4905, 4380, 4923, 4406, 4272, 4907, 4816, 4755, 4748, 4714, 4810, 4763, 4765, 4682, 4839, 4793, 4735, 4788, 4770, 4711, 4854, 4812, 4312, 4275, 4789, 4799, 4803, 4785, 4781, 4853, 4811, 4784, 4805, 4690, 4310, 4855, 5331, 5031, 4820, 4701, 4377, 4697, 4748, 4820, 4822, 4794, 4672, 4949, 4284, 4803, 4693]
]
    
k = 1
for n in results:
    total_time = 0
    for time in n:
        total_time += time
    
    print("avg for", k, "thread(s) =",  total_time / len(n))
    k = k + 1
