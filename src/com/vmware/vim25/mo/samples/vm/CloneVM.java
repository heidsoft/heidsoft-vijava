/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

 * Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

 * Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo.samples.vm;

import java.net.URL;

import com.vmware.vim25.CustomizationAdapterMapping;
import com.vmware.vim25.CustomizationFixedIp;
import com.vmware.vim25.CustomizationFixedName;
import com.vmware.vim25.CustomizationGlobalIPSettings;
import com.vmware.vim25.CustomizationIPSettings;
import com.vmware.vim25.CustomizationLinuxOptions;
import com.vmware.vim25.CustomizationLinuxPrep;
import com.vmware.vim25.CustomizationSpec;
import com.vmware.vim25.CustomizationSpecInfo;
import com.vmware.vim25.CustomizationSpecItem;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.mo.ClusterComputeResource;
import com.vmware.vim25.mo.CustomizationSpecManager;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ResourcePool;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * 
 * @author Steve Jin
 */

public class CloneVM {
	public static void main(String[] args) throws Exception {

		System.out.println("=================自定义虚拟机===============");
		String vmname = "redhat6";
		String cloneName = "myclonetest";

		ServiceInstance si = new ServiceInstance(new URL(
				"https://10.192.18.220/sdk"), "administrator", "1qaz@WSX", true);
		Folder rootFolder = si.getRootFolder();
		VirtualMachine vm = (VirtualMachine) new InventoryNavigator(rootFolder)
				.searchManagedEntity("VirtualMachine", vmname);

//		ClusterComputeResource mycluster = (ClusterComputeResource) new InventoryNavigator(
//				rootFolder).searchManagedEntity("ClusterComputeResource",
//				"vmware");
//		ResourcePool rp = null;
//		rp = mycluster.getResourcePool();
//		Datastore[] mydatastores = mycluster.getDatastores();
//		Datastore retDatastore = null;
//		long tmpSanSize = 0;
//		for (int i = 0; i < mydatastores.length; i++) {
//			Datastore data = (Datastore) mydatastores[i];
//			if (data.getInfo().getUrl().indexOf("vmfs") != -1
//					&& data.getHost().length >= 2
//					&& data.getInfo().getName().equals("3p")) {
//				if (tmpSanSize < data.getInfo().getFreeSpace()) {
//					tmpSanSize = data.getInfo().getFreeSpace();
//					retDatastore = data;
//				}
//			}
//
//		}
//
//		if (vm == null) {
//			System.out.println("No VM " + vmname + " found");
//			si.getServerConnection().logout();
//			return;
//		}
//
//		// 虚拟机克隆方案创建
//		VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
//		// Datacenter dc = (Datacenter) new InventoryNavigator(rootFolder)
//		// .searchManagedEntity("Datacenter", "CPIC");
//		// ResourcePool rp = (ResourcePool) new InventoryNavigator(dc)
//		// .searchManagedEntities("ResourcePool")[0];
//
//		// CustomizationSpec数据对象类型包含需要自定义虚拟机部署时或将其迁移到新的主机的信息。
//		CustomizationSpec cspec = new CustomizationSpec();
//		CustomizationSpecInfo info = new CustomizationSpecInfo();
//		CustomizationSpecItem specItem = new CustomizationSpecItem();
//
//		CustomizationAdapterMapping adaptorMap = new CustomizationAdapterMapping();
//		CustomizationIPSettings adapter = new CustomizationIPSettings();
//		CustomizationFixedIp fixedIp = new CustomizationFixedIp();// 指定使用固定ip
//		CustomizationGlobalIPSettings gIP = new CustomizationGlobalIPSettings();
//
//		info.setDescription("xxx");
//		info.setName("aaa");
//		info.setType("Linux");// 设置克隆机器的操作系统类型
//
//		specItem.setInfo(info);
//		specItem.setSpec(cspec);
//
//		// dns列表
//		String dnsList[] = new String[] { "10.193.16.105", "8.8.8.8" };
//		String ipAddress = "10.192.28.21";
//		String subNetMask = "255.255.255.0";
//
//		adapter.setDnsServerList(dnsList);
//		adapter.setGateway(new String[] { "10.192.28.254" });
//		adapter.setIp(fixedIp);
//		adapter.setSubnetMask(subNetMask);
//
//		fixedIp.setIpAddress(ipAddress);
//		adaptorMap.setAdapter(adapter);
//
//		// 不能使用MAC设置
//		// adaptorMap.setMacAddress("00:50:56:a3:07:33");
//		String dnsSuffixList[] = new String[] { "cpic.com", "cpic.cn" };
//		gIP.setDnsSuffixList(dnsSuffixList);
//		gIP.setDnsServerList(dnsList);
//
//		CustomizationFixedName computerName = new CustomizationFixedName();
//		computerName.setName("pppppa");
//
//		CustomizationAdapterMapping[] nicSettingMap = new CustomizationAdapterMapping[] { adaptorMap };
//		CustomizationLinuxOptions linuxOptions = new CustomizationLinuxOptions();
//		CustomizationLinuxPrep cLinuxPrep = new CustomizationLinuxPrep();
//		cLinuxPrep.setDomain("cpic.com");
//		cLinuxPrep.setHostName(computerName);
//		cLinuxPrep.setHwClockUTC(true);
//		cLinuxPrep.setTimeZone("Canada/Eastern");
//
//		CustomizationSpecManager specManager = si.getCustomizationSpecManager();
//
//		cspec.setGlobalIPSettings(gIP);
//		cspec.setOptions(linuxOptions);
//		cspec.setIdentity(cLinuxPrep);
//		cspec.setNicSettingMap(nicSettingMap);
//		cspec.setEncryptionKey(specManager.getEncryptionKey());
//
//		VirtualMachineRelocateSpec relocateSpec = new VirtualMachineRelocateSpec();
//		relocateSpec.setPool(rp.getMOR());
//		relocateSpec.setDatastore(retDatastore.getMOR());
//
//		cloneSpec.setLocation(relocateSpec);
//		cloneSpec.setPowerOn(true);
//		cloneSpec.setTemplate(false);
//		cloneSpec.setCustomization(cspec);
//
//		try {
//
//			vm.checkCustomizationSpec(specItem.getSpec());
//			Task task = vm.cloneVM_Task((Folder) vm.getParent(), cloneName,
//					cloneSpec);
//			System.out.println("Launching the VM clone task."
//					+ "Please wait ...");
//			String status = task.waitForMe();
//			if (status == Task.SUCCESS) {
//				System.out.println("VM got cloned successfully.");
//			} else {
//				System.out.println("Failure -: VM cannot be cloned");
//			}
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
		
//		VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
//		vmConfigSpec.setAnnotation("aaaaaaaaaaaaaaa"); // desired value
//		
//		
//		vm.reconfigVM_Task(vmConfigSpec);// invoke the API
		//System.out.println("注释获取:"+vm.getConfig().getAnnotation());


	}
}
