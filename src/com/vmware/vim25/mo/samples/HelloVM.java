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

package com.vmware.vim25.mo.samples;

import java.net.URL;

import com.vmware.vim25.CustomFieldDef;
import com.vmware.vim25.CustomFieldValue;
import com.vmware.vim25.Tag;
import com.vmware.vim25.mo.ClusterComputeResource;
import com.vmware.vim25.mo.ComputeResource;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

public class HelloVM 
{
	public static void main(String[] args) throws Exception
	{
//		long start = System.currentTimeMillis();
//		ServiceInstance si = new ServiceInstance(new URL("https://192.168.150.2/sdk"), "administrator", "mandrake", true);
		ServiceInstance si = new ServiceInstance(new URL("https://10.192.18.220/sdk"), "administrator", "1qaz@WSX", true);
		//ServiceInstance si = new ServiceInstance(new URL("https://10.192.18.106/sdk"), "yuntest", "Cpic1234", true);
		//ServiceInstance si = new ServiceInstance(new URL("https://10.192.18.105/sdk"), "yuntest", "Cpic1234", true);
		//ServiceInstance si = new ServiceInstance(new URL("https://10.192.18.144/sdk"), "yuntest", "Cpic1234", true);
		//ServiceInstance si = new ServiceInstance(new URL("https://10.196.37.1/sdk"), "yuntest", "Cpic1234", true);
		//ServiceInstance si = new ServiceInstance(new URL("https://192.168.150.21/sdk"), "root", "vmware", true);
//		long end = System.currentTimeMillis();
		
		Folder rootFolder = si.getRootFolder();
//		String name = rootFolder.getName();
//		
//		SessionManager sm = si.getSessionManager();
//		String ticket = sm.acquireCloneTicket();
//		System.out.println(ticket);
//		//System.out.println("ticket="+ticket);
//
//		String thumberPrint = StringUtils.substring(ticket, StringUtils.indexOf(ticket, "--") + 5);
//		thumberPrint = StringUtils.replace(thumberPrint, "-", ":");
//		System.out.println("thumbprint=" + thumberPrint);
	    ClusterComputeResource mycluster = (ClusterComputeResource) new InventoryNavigator(
  				rootFolder).searchManagedEntity("ClusterComputeResource","vmware");

        Datastore[] datastore=mycluster.getDatastores();
		//ManagedEntity[] datastore = new InventoryNavigator(rootFolder).searchManagedEntities("Datastore");
		
//        long tmpSanSize=0;
//        long retSanSzie=0;
//        Datastore retDatastore = null;
//        for(int i=0;i<datastore.length;i++){
//			Datastore data=(Datastore)datastore[i];
//			//System.out.println(data.getIormConfiguration().getStatsCollectionEnabled());
//			//System.out.println(data.getIormConfiguration().getStatsAggregationDisabled());
//			//System.out.println(data.getIormConfiguration().getPercentOfPeakThroughput());
//			System.out.println(data.getIormConfiguration().getCongestionThresholdMode());
//			System.out.println(data.getAlarmActionEabled());
//
//			if(data.getInfo().getUrl().indexOf("vmfs")!=-1&&data.getHost().length>=2){
//				//System.out.println("存储节点名称:"+data.getName());
//				//System.out.println("存储节点url:"+data.getInfo().getUrl());
//				//System.out.println("剩余空间:"+data.getInfo().getFreeSpace());
//				//System.out.println("动态属性类型:"+data.getInfo().getDynamicType());
//				//System.out.println("最大文件大小:"+data.getInfo().getMaxFileSize());
//				//System.out.println("动态属性:"+data.getInfo().getDynamicProperty());			
//				if(tmpSanSize<data.getInfo().getFreeSpace()){
//					tmpSanSize=data.getInfo().getFreeSpace();
//					retDatastore=data;
//				}
//				
//				
////				System.out.println("剩余空间最大的是:"+tmpSanSize);
//			}
//				
//		
//		}
//        System.out.println("存储节点名称:"+retDatastore.getName());
//        System.out.println("存储挂载的主机个数是:"+retDatastore.getHost().length);	
		//ManagedEntity
	
//		Datacenter myDc = (Datacenter) new InventoryNavigator(rootFolder).searchManagedEntity("Datacenter","sjcloud");
//		System.out.println("myDcName="+myDc.getHostFolder().getName());
//		System.out.println("datastore="+myDc.getDatastoreFolder().getName());
//		for(int i=0;i<hostFolderChilds.length;i++){
//		    System.out.println("childType="+hostFolderChilds[i]);
//		}
//		for(int i=0;i<childEntitys.length;i++){
//		    System.out.println("childEntity="+childEntitys[i].getName());
//		    System.out.println("childEntity type="+childEntitys[i].getMOR().type);
//		}
//		
//		ManagedEntity[]  myClusters = new InventoryNavigator(rootFolder).searchManagedEntities("ClusterComputeResource");
//		ClusterComputeResource[] clusters = (ClusterComputeResource[])new InventoryNavigator(
//			myDc.getHostFolder()).searchManagedEntities(new String[][]{{
//			"ClusterComputeResource", "name" }, }, true);
		
//		ManagedEntity[] managedEntitys=rootFolder.getChildEntity();

	
//		AboutInfo ai = rootFolder.getServerConnection().getServiceInstance().getAboutInfo();
//		System.out.println("vcenter build:"+ai.getBuild());
//		System.out.println("vcenter FullName:"+ai.getFullName());
//		System.out.println("vcenter OsType:"+ai.getOsType());
//		System.out.println("vcenter ProductLineId:"+ai.getProductLineId());
//		System.out.println("vcenter Vendor:"+ai.getVendor());

		
		ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
		if(mes==null || mes.length ==0)
		{
		    return;
		}	
	
		for(int i=0;i<mes.length;i++)
		{
		    
		    VirtualMachine vm = (VirtualMachine) mes[i]; 
		    System.out.println(vm.getConfig().getAnnotation());
		    
//		    ComputeResource resource=vm.getResourcePool().getOwner();
		    
		   
//		    System.out.println(vm.getParent().getParent().getMOR().getType());
//		    if("Datacenter".equals(vm.getParent().getParent().getMOR().getType())){
//		//	  ManagedEntity tmpMe=new ManagedEntity(si.getServerConnection(),vm.getParent().getParent().getMOR());
//			  //String dcname=tmpMe.getName();
//			  Datacenter adc=new Datacenter(si.getServerConnection(),vm.getParent().getParent().getMOR());
////			  Datacenter myDc = (Datacenter) new InventoryNavigator(rootFolder)
////				.searchManagedEntity("Datacenter",dcname);
//			  
//			  ManagedEntity[] childEntitys=adc.getHostFolder().getChildEntity();
//			  System.out.println("childEntitys:"+childEntitys.length);
//				for(int g=0;g<childEntitys.length;g++){
//					if("ClusterComputeResource".equals(childEntitys[i].getMOR().type)){
//						ClusterComputeResource csr=(ClusterComputeResource)childEntitys[g];
//						System.out.println(csr.getName());
//					}
//				}
//		    }
//		    CustomFieldValue[] hello=vm.getValues();
//		    vm.getEnvironmentBrowser().getPropertyByPath("myuser");
//		    System.out.println(vm.getEnvironmentBrowser().getPropertyByPath("myuser"));
//
//		    for(int j=0;j<hello.length;j++){  	 
//		    	 System.out.println(hello[i].getDynamicType());
//		    }
	
		   // if(vm.getConfig().template){
		    //System.out.println("pppppppp"+rp.getMOR().getType());
		   // System.out.println("parentType:"+vm.getParent().getParent().getMOR().getType());
//		    System.out.println("vmname:"+vm.getName());
//		    System.out.println("type="+vm.getMOR().get_value());
		   // }

//		    System.out.println("vmSnapshotDir:"+vm.getConfig().getFiles().getSnapshotDirectory());
//		    System.out.println("vmGuestId:"+vm.getConfig().getGuestId());
//		    System.out.println("version:"+vm.getConfig().getVersion());
//		    System.out.println("IpAllocationPolicy:"+vm.getConfig().getVAppConfig().getIpAssignment().getIpAllocationPolicy());
//		    System.out.println("vmmem:"+vm.getConfig().getHardware().getMemoryMB());
//		    ResourcePool pool= vm.getResourcePool();
//		    ComputeResource resource=pool.getOwner();
//		    System.out.println("hostname:"+resource.getHosts()[i].getName());
//		    System.out.println("hostuuid:"+resource.getHosts()[i].getHardware().getSystemInfo().getUuid());
//		    System.out.println("poolname:"+pool.getName());
//		    System.out.println("ipaddress:"+vm.getGuest().getIpAddress());
//		    System.out.println("nameid:" + vm.getName());
		}
		
		
		
//		VirtualMachineConfigInfo vminfo = vm.getConfig();
//		VirtualMachineCapability vmc = vm.getCapability();
//	
//		vm.getResourcePool();
//		System.out.println("Hello " + vm.getName());
//		
//		System.out.println("GuestOS: " + vminfo.getGuestFullName());
//
//		System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());

//		ManagedEntity[] templates =new InventoryNavigator(rootFolder).searchManagedEntities("Folder");
//		for(int i=0;i<templates.length;i++){
//		    Folder dir = (Folder) templates[i]; 
//		    System.out.println(dir.getName());
//		}	
		
		
//		ClusterComputeResource mycluster = (ClusterComputeResource) new InventoryNavigator(
//			si.getRootFolder()).searchManagedEntity(
//			"ClusterComputeResource","vmware");
		
//		HostSystem myHost = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem","192.168.150.4");
//		System.out.println("hostmap="+myHost);
		System.out.println("aaaaaaaaaaa");
		si.getServerConnection().logout();
	}

}
