/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormsignorgname',
          prop: 'ormsignorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormsignorgid',
          prop: 'ormsignorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'isdefaultsignorg',
          prop: 'isdefaultsignorg',
          dataType: 'NSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'contractsignorgname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'contractsignorgid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'contractsignorgid',
          dataType: 'GUID',
        },
        {
          name: 'contractsignorgid',
          prop: 'contractsignorgid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimcontractsignorg',
          prop: 'contractsignorgid',
        },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}