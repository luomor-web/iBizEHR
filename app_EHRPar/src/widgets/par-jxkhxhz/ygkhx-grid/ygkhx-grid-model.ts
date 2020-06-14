/**
 * YGKHX 部件模型
 *
 * @export
 * @class YGKHXModel
 */
export default class YGKHXModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof YGKHXGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof YGKHXGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'yg',
          prop: 'yg',
          dataType: 'TEXT',
        },
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'INT',
        },
        {
          name: 'gznljtd',
          prop: 'gznljtd',
          dataType: 'FLOAT',
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
          prop: 'parjxkhxhzname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parjxkhxhzid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parjxkhxhzid',
          dataType: 'GUID',
        },
        {
          name: 'ywnlks',
          prop: 'ywnlks',
          dataType: 'FLOAT',
        },
        {
          name: 'gzjx',
          prop: 'gzjx',
          dataType: 'FLOAT',
        },
        {
          name: 'gznljtd_xbn',
          prop: 'gznljtd_xbn',
          dataType: 'FLOAT',
        },
        {
          name: 'jswmjc',
          prop: 'jswmjc',
          dataType: 'FLOAT',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'TEXT',
        },
        {
          name: 'ygid',
          prop: 'ygid',
          dataType: 'TEXT',
        },
        {
          name: 'parjxkhxhz',
          prop: 'parjxkhxhzid',
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