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
          name: 'pfzt',
          prop: 'pfzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'khobject_text',
          prop: 'khobject',
          dataType: 'SSCODELIST',
        },
        {
          name: 'parkhzcmxid',
          prop: 'parkhzcmxid',
          dataType: 'PICKUP',
        },
        {
          name: 'qzzb',
          prop: 'qzzb',
          dataType: 'FLOAT',
        },
        {
          name: 'khobject',
          prop: 'khobject',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'parldkhqzname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parldkhqzid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parldkhqzid',
          dataType: 'GUID',
        },
        {
          name: 'parldkhqz',
          prop: 'parldkhqzid',
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