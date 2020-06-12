/**
 * NDLHMBXZMX 部件模型
 *
 * @export
 * @class NDLHMBXZMXModel
 */
export default class NDLHMBXZMXModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof NDLHMBXZMXGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof NDLHMBXZMXGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'fz',
          prop: 'fz',
          dataType: 'FLOAT',
        },
        {
          name: 'parldndlhmbmxname',
          prop: 'parldndlhmbmxname',
          dataType: 'TEXT',
        },
        {
          name: 'xgrz',
          prop: 'xgrz',
          dataType: 'TEXT',
        },
        {
          name: 'zt',
          prop: 'zt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'mblhyq',
          prop: 'mblhyq',
          dataType: 'TEXT',
        },
        {
          name: 'mblx',
          prop: 'mblx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'parldndlhmbname',
          prop: 'parldndlhmbname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'parldndlhmbmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parldndlhmbmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parldndlhmbmxid',
          dataType: 'GUID',
        },
        {
          name: 'parldndlhmbid',
          prop: 'parldndlhmbid',
          dataType: 'PICKUP',
        },
        {
          name: 'khbf',
          prop: 'khbf',
          dataType: 'TEXT',
        },
        {
          name: 'parldndlhmbmx',
          prop: 'parldndlhmbmxid',
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