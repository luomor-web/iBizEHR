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
          name: 'zf',
          prop: 'zf',
          dataType: 'FLOAT',
        },
        {
          name: 'yg',
          prop: 'yg',
          dataType: 'TEXT',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ygid',
          prop: 'ygid',
          dataType: 'TEXT',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'TEXT',
        },
        {
          name: 'khlx',
          prop: 'khlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'parjxjgname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parjxjgid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parjxjgid',
          dataType: 'GUID',
        },
        {
          name: 'parjxjg',
          prop: 'parjxjgid',
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