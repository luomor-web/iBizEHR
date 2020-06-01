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
          name: 'phaseinfo',
          prop: 'phaseinfo',
          dataType: 'TEXT',
        },
        {
          name: 'initapplydate',
          prop: 'initapplydate',
          dataType: 'DATE',
        },
        {
          name: 'tdzwxxname',
          prop: 'tdzwxxname',
          dataType: 'TEXT',
        },
        {
          name: 'department',
          prop: 'department',
          dataType: 'TEXT',
        },
        {
          name: 'statusinfo',
          prop: 'statusinfo',
          dataType: 'TEXT',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'tdzwxxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'tdzwxxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'tdzwxxid',
          dataType: 'GUID',
        },
        {
          name: 'jobid',
          prop: 'jobid',
          dataType: 'TEXT',
        },
        {
          name: 'pcmtdzwxx',
          prop: 'tdzwxxid',
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