/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'sfgx',
          prop: 'sfgx',
          dataType: 'YESNO',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainteachername',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainteacherid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainteacherid',
          dataType: 'GUID',
        },
        {
          name: 'jslx',
          prop: 'jslx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainagencyid',
          prop: 'trmtrainagencyid',
          dataType: 'PICKUP',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'dj',
          prop: 'dj',
          dataType: 'TEXT',
        },
        {
          name: 'xb',
          prop: 'xb',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zjkssj',
          prop: 'zjkssj',
          dataType: 'DATE',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'nl',
          prop: 'nl',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'trmtrainteacher',
          prop: 'trmtrainteacherid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtrainagencyname_like',
        prop: 'n_trmtrainagencyname_like',
        dataType: 'PICKUPTEXT',
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