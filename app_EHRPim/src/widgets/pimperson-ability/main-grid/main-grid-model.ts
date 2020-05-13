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
          name: 'performscore',
          prop: 'performscore',
          dataType: 'FLOAT',
        },
        {
          name: 'techscore',
          prop: 'techscore',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'eduscore',
          prop: 'eduscore',
          dataType: 'FLOAT',
        },
        {
          name: 'pracscore',
          prop: 'pracscore',
          dataType: 'FLOAT',
        },
        {
          name: 'pimpersonabilityname',
          prop: 'pimpersonabilityname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonabilityname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimpersonabilityid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpersonabilityid',
          dataType: 'GUID',
        },
        {
          name: 'month',
          prop: 'month',
          dataType: 'INT',
        },
        {
          name: 'year',
          prop: 'year',
          dataType: 'INT',
        },
        {
          name: 'trainresultscore',
          prop: 'trainresultscore',
          dataType: 'FLOAT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimpersonability',
          prop: 'pimpersonabilityid',
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