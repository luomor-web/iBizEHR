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
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'trainres',
          prop: 'trainres',
          dataType: 'TEXT',
        },
        {
          name: 'fs',
          prop: 'fs',
          dataType: 'FLOAT',
        },
        {
          name: 'pxjg',
          prop: 'pxjg',
          dataType: 'TEXT',
        },
        {
          name: 'trainend',
          prop: 'trainend',
          dataType: 'DATE',
        },
        {
          name: 'trmtrainplantermid',
          prop: 'trmtrainplantermid',
          dataType: 'PICKUP',
        },
        {
          name: 'trainbegin',
          prop: 'trainbegin',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrianpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrianpersonid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrianpersonid',
          dataType: 'GUID',
        },
        {
          name: 'pxkc',
          prop: 'pxkc',
          dataType: 'TEXT',
        },
        {
          name: 'pxbj',
          prop: 'pxbj',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainperson',
          prop: 'trmtrianpersonid',
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