/**
 * YTG 部件模型
 *
 * @export
 * @class YTGModel
 */
export default class YTGModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof YTGModel
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
        prop: 'pimexitandentryid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimexitandentryname',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'cjsj',
        prop: 'cjsj',
        dataType: 'DATE',
      },
      {
        name: 'rjsj',
        prop: 'rjsj',
        dataType: 'DATE',
      },
      {
        name: 'qwfhgj',
        prop: 'qwfhgj',
        dataType: 'TEXT',
      },
      {
        name: 'lx',
        prop: 'lx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sy',
        prop: 'sy',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'TEXT',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'TEXT',
      },
      {
        name: 'workflowstate',
        prop: 'workflowstate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimexitandentryid',
        prop: 'pimexitandentryid',
        dataType: 'GUID',
      },
      {
        name: 'pimexitandentry',
        prop: 'pimexitandentryid',
        dataType: 'FONTKEY',
      },
    ]
  }

}