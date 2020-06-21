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
        prop: 'trmtrainfaciesid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainfaciesname',
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
        name: 'sslb',
        prop: 'sslb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sssl',
        prop: 'sssl',
        dataType: 'INT',
      },
      {
        name: 'dd',
        prop: 'dd',
        dataType: 'TEXT',
      },
      {
        name: 'trmtrainaddressid',
        prop: 'trmtrainaddressid',
        dataType: 'PICKUP',
      },
      {
        name: 'yysb',
        prop: 'yysb',
        dataType: 'SMCODELIST',
      },
      {
        name: 'bgsb',
        prop: 'bgsb',
        dataType: 'SMCODELIST',
      },
      {
        name: 'dgsb',
        prop: 'dgsb',
        dataType: 'SMCODELIST',
      },
      {
        name: 'sb',
        prop: 'sb',
        dataType: 'SMCODELIST',
      },
      {
        name: 'sszp',
        prop: 'sszp',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainfaciesid',
        prop: 'trmtrainfaciesid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainfacies',
        prop: 'trmtrainfaciesid',
        dataType: 'FONTKEY',
      },
    ]
  }

}