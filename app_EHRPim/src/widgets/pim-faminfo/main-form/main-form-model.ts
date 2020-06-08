/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimfaminfoid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimfaminfoname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ybrgx',
        prop: 'ybrgx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimfaminfoname',
        prop: 'pimfaminfoname',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'zjlx',
        prop: 'zjlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zjh',
        prop: 'zjh',
        dataType: 'TEXT',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'nl',
        prop: 'nl',
        dataType: 'INT',
      },
      {
        name: 'gzdw',
        prop: 'gzdw',
        dataType: 'TEXT',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'TEXT',
      },
      {
        name: 'zzmm',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sruvivors',
        prop: 'sruvivors',
        dataType: 'YESNO',
      },
      {
        name: 'sfjjllr',
        prop: 'sfjjllr',
        dataType: 'SSCODELIST',
      },
      {
        name: 'telphone',
        prop: 'telphone',
        dataType: 'TEXT',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jlczz',
        prop: 'jlczz',
        dataType: 'TEXT',
      },
      {
        name: 'pimfaminfoid',
        prop: 'pimfaminfoid',
        dataType: 'GUID',
      },
      {
        name: 'pimfaminfo',
        prop: 'pimfaminfoid',
        dataType: 'FONTKEY',
      },
    ]
  }

}