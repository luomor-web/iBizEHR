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
          name: 'gwzzsm',
          prop: 'gwzzsm',
          dataType: 'TEXT',
        },
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'INT',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'numcompilation',
          prop: 'numcompilation',
          dataType: 'INT',
        },
        {
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'ormgwbzid',
          prop: 'ormgwbzid',
          dataType: 'PICKUP',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'ormbmgwbzname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormbmgwbzid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'ormbmgwbzid',
          dataType: 'GUID',
        },
        {
          name: 'ormgwbzmc',
          prop: 'ormgwbzmc',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormbmgwbz',
          prop: 'ormbmgwbzid',
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