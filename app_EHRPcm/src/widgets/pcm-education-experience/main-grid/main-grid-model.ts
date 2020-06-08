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
          name: 'endtime',
          prop: 'endtime',
          dataType: 'DATE',
        },
        {
          name: 'starttime',
          prop: 'starttime',
          dataType: 'DATE',
        },
        {
          name: 'xl',
          prop: 'xl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xkml',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xxxz',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'majorname',
          prop: 'majorname',
          dataType: 'TEXT',
        },
        {
          name: 'xznf',
          prop: 'xznf',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmeducationexperiencename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmeducationexperienceid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmeducationexperienceid',
          dataType: 'GUID',
        },
        {
          name: 'xwz',
          prop: 'xwz',
          dataType: 'TEXT',
        },
        {
          name: 'firstxl',
          prop: 'firstxl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'formsoflearning_text',
          prop: 'formsoflearning',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xl_text',
          prop: 'xl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'schoolname',
          prop: 'schoolname',
          dataType: 'TEXT',
        },
        {
          name: 'higestxl',
          prop: 'higestxl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'formsoflearning',
          prop: 'formsoflearning',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xlyz',
          prop: 'xlyz',
          dataType: 'TEXT',
        },
        {
          name: 'byz',
          prop: 'byz',
          dataType: 'TEXT',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'PICKUP',
        },
        {
          name: 'xkml_text',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xxxz_text',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmeducationexperience',
          prop: 'pcmeducationexperienceid',
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